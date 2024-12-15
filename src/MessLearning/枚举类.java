package MessLearning;

import entity.enums.SysSettingCodeEnum;

public class 枚举类 {
    public static void main(String[] args) {
        for (SysSettingCodeEnum value : SysSettingCodeEnum.values()) {
            System.out.println(value);
        }
        System.out.println();
        SysSettingCodeEnum audit = SysSettingCodeEnum.AUDIT;
        System.out.println(audit.getCode());
        System.out.println();
        System.out.println(SysSettingCodeEnum.valueOf("AUDIT").getCode());
    }
}
