package LIST;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test1 {



    public static void main(String[] args) {
        ArrayList<OrderDTO> orderDTOList = new ArrayList<>();
        orderDTOList.add(OrderDTO.builder().id("李四").userId(123).build());
        orderDTOList.add(OrderDTO.builder().id("张三").userId(123).build());
        orderDTOList.add(OrderDTO.builder().id("李四").userId(123).build());
        orderDTOList.add(OrderDTO.builder().id("王五").userId(123).build());
        orderDTOList.add(OrderDTO.builder().id("张三").userId(123).build());
        Map<String, List<OrderDTO>> collect = orderDTOList.stream().collect(Collectors.groupingBy(OrderDTO::getId));
        collect.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });
    }
}
