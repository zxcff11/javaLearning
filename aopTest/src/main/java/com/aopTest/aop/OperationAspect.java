//package com.aopTest.aop;
//
//
//import com.easybbs.annotation.GlobalInterceptor;
//import com.easybbs.annotation.VerifyParam;
//import com.easybbs.entity.config.WebConfig;
//import com.easybbs.entity.constants.Constants;
//import com.easybbs.entity.dto.SessionWebUserDto;
//import com.easybbs.entity.dto.SysSettingDto;
//import com.easybbs.entity.enums.DateTimePatternEnum;
//import com.easybbs.entity.enums.ResponseCodeEnum;
//import com.easybbs.entity.enums.UserOperFrequencyTypeEnum;
//import com.easybbs.entity.query.ForumArticleQuery;
//import com.easybbs.entity.query.ForumCommentQuery;
//import com.easybbs.entity.query.LikeRecordQuery;
//import com.easybbs.entity.vo.ResponseVO;
//import com.easybbs.exception.BusinessException;
//import com.easybbs.service.ForumArticleService;
//import com.easybbs.service.ForumCommentService;
//import com.easybbs.service.LikeRecordService;
//import com.easybbs.service.UserInfoService;
//import com.easybbs.utils.DateUtil;
//import com.easybbs.utils.StringTools;
//import com.easybbs.utils.SysCacheUtils;
//import com.easybbs.utils.VerifyUtils;
//import org.apache.commons.lang3.ArrayUtils;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import java.lang.reflect.Method;
//import java.lang.reflect.Parameter;
//import java.util.Date;
//
//@Component
//@Aspect
//public class OperationAspect {
//    private static Logger logger = LoggerFactory.getLogger(OperationAspect.class);
//    private static final String[] TYPE_BASE = {"java.lang.String", "java.lang.INTEGER", "java.lang.Long"};
//
//    @Resource
//    private WebConfig webConfig;
//
//    @Resource
//    private ForumArticleService forumArticleService;
//
//    @Resource
//    private ForumCommentService forumCommentService;
//
//    @Resource
//    private LikeRecordService likeRecordService;
//
//    @Resource
//    private UserInfoService userInfoService;
//
//
//    @Pointcut("@annotation(com.easybbs.annotation.GlobalInterceptor)")
//    private void requestInterceptor() {
//
//
//    }
//
//    @Around("requestInterceptor()")
//    public Object interceptorDo(ProceedingJoinPoint point) {
//        try {
//            Object target = point.getTarget();
//            Object[] arguments = point.getArgs();
//            String methodName = point.getSignature().getName();
//            Class<?>[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();
//            Method method = target.getClass().getMethod(methodName, parameterTypes);
//            GlobalInterceptor interceptor = method.getAnnotation(GlobalInterceptor.class);
//            if (interceptor == null) {
//                return null;
//            }
////            校验参数
//            if (interceptor.checkParams()) {
//                validateParams(method, arguments);
//            }
////            验证登录
//            if (interceptor.checkLogin()) {
//                checkLogin();
//            }
//            /**
//             * 校验频率
//             */
//            this.checkFrequency(interceptor.frequencyType());
//
//            Object pointResult = point.proceed();
//            /**
//             * 增加频次限制
//             */
//            //instanceof 检查pointResult是否是pointResult的实例
//            if (pointResult instanceof ResponseVO) {
//                ResponseVO responseVO = (ResponseVO) pointResult;
//                if (Constants.STATUC_SUCCESS.equals(responseVO.getStatus())) {
//                    addOpCount(interceptor.frequencyType());
//                }
//            }
//
//
//            return pointResult;
//        } catch (BusinessException e) {
//            logger.error("全局拦截器异常", e);
//            throw e;
//        } catch (Exception e) {
//            logger.error("全局拦截器异常", e);
//            throw new BusinessException(ResponseCodeEnum.CODE_500);
//        } catch (Throwable e) {
//            logger.error("全局拦截器异常", e);
//            throw new BusinessException(ResponseCodeEnum.CODE_500);
//        }
//    }
//
//    private void checkLogin() {
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        HttpSession session = request.getSession();
//        Object obj = session.getAttribute(Constants.SESSION_KEY);
//        if(null==obj){
//            throw new BusinessException(ResponseCodeEnum.CODE_901);
//        }
//    }
//
//    private void validateParams(Method m, Object[] arguments) throws BusinessException {
//
//
//        Parameter[] parameters = m.getParameters();
//        for (int i = 0; i < parameters.length; i++) {
//            Parameter parameter = parameters[i];
//            Object value = arguments[i];
//            VerifyParam verifyParam = parameter.getAnnotation(VerifyParam.class);
//            if (verifyParam == null) {
//                continue;
//            }
//            if (ArrayUtils.contains(TYPE_BASE, parameter.getParameterizedType().getTypeName())) {
//                checkValue(value, verifyParam);
//            }
//        }
//
//
//    }
//
//    private void checkValue(Object value, VerifyParam verifyParam) {
//        Boolean isEmpty = value == null || StringTools.isEmpty(value.toString());
//        Integer length = value == null ? 0 : value.toString().length();
//
//
////        校验空
//        if (isEmpty && verifyParam.required()) {
//            throw new BusinessException(ResponseCodeEnum.CODE_600);
//        }
////        校验长度
//        if (!isEmpty && (verifyParam.max() != -1 && length > verifyParam.max() || verifyParam.min() != -1 && length < verifyParam.min())) {
//            throw new BusinessException(ResponseCodeEnum.CODE_600);
//        }
////        校验正则
//        if (!isEmpty && !StringTools.isEmpty(verifyParam.regex().getRegex()) && !VerifyUtils.verify(verifyParam.regex(), String.valueOf(value))) {
//            throw new BusinessException(ResponseCodeEnum.CODE_600);
//        }
//    }
//
//    private void checkFrequency(UserOperFrequencyTypeEnum typeEnum) {
//        if (typeEnum == null || typeEnum == UserOperFrequencyTypeEnum.NO_CHECK) {
//            return;
//        }
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        HttpSession session = request.getSession();
//        SessionWebUserDto webUserDto = (SessionWebUserDto) session.getAttribute(Constants.SESSION_KEY);
//        String curDate = DateUtil.format(new Date(), DateTimePatternEnum.YYYY_MM_DD.getPattern());
//        String sessionKey = Constants.SESSION_KEY_FREQUENCY + curDate + typeEnum;
//        Integer count = (Integer) session.getAttribute(sessionKey);
//        SysSettingDto sysSettingDto = SysCacheUtils.getSysSetting();
//        switch (typeEnum) {
//            case POST_ARTICLE:
//                if (count == null) {
//                    ForumArticleQuery forumArticleQuery = new ForumArticleQuery();
//                    forumArticleQuery.setUserId(webUserDto.getUserId());
//                    forumArticleQuery.setPostTimeStart(curDate);
//                    forumArticleQuery.setPostTimeEnd(curDate);
//                    count = forumArticleService.findCountByParam(forumArticleQuery);
//                }
//                if (count >= sysSettingDto.getPostSetting().getPostDayCountThreshold()) {
//                    throw new BusinessException(ResponseCodeEnum.CODE_602);
//                }
//                break;
//            case POST_COMMENT:
//                if (count == null) {
//                    ForumCommentQuery forumCommentQuery = new ForumCommentQuery();
//                    forumCommentQuery.setUserId(webUserDto.getUserId());
//                    forumCommentQuery.setPostTimeStart(curDate);
//                    forumCommentQuery.setPostTimeEnd(curDate);
//                    count = forumCommentService.findCountByParam(forumCommentQuery);
//                }
//
//                if (count >= sysSettingDto.getCommentSetting().getCommentDayCountThreshold()) {
//                    throw new BusinessException(ResponseCodeEnum.CODE_602);
//                }
//                break;
//            case DO_LIKE:
//                if (count == null) {
//                    LikeRecordQuery recordQuery = new LikeRecordQuery();
//                    recordQuery.setUserId(webUserDto.getUserId());
//                    recordQuery.setCreateTimeStart(curDate);
//                    recordQuery.setCreateTimeEnd(curDate);
//                    count = likeRecordService.findCountByParam(recordQuery);
//
//                }
//                if (count >= sysSettingDto.getLikeSetting().getLikeDayCountThreshold()) {
//                    throw new BusinessException(ResponseCodeEnum.CODE_602);
//                }
//                break;
//            case IMAGE_UPLAOD:
//                if (count == null) {
//                    count = 0;
//                }
//                if (count >= sysSettingDto.getPostSetting().getDayImageUploadCount()) {
//                    throw new BusinessException(ResponseCodeEnum.CODE_602);
//                }
//                break;
//        }
//        session.setAttribute(sessionKey, count);
//    }
//
//    //统计已经统计数据
//    private void addOpCount(UserOperFrequencyTypeEnum typeEnum) {
//        if (typeEnum == null || typeEnum == UserOperFrequencyTypeEnum.NO_CHECK) {
//            return;
//        }
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        HttpSession session = request.getSession();
//        String curDate = DateUtil.format(new Date(), DateTimePatternEnum.YYYY_MM_DD.getPattern());
//        String sessionKey = Constants.SESSION_KEY_FREQUENCY + curDate + typeEnum;
//        Integer count = (Integer) session.getAttribute(sessionKey);
//        session.setAttribute(sessionKey, count + 1);
//    }
//
//
//}