package inventory.control.api.mapper;

import inventory.control.api.dto.request.OutpuItemRequest;
import inventory.control.api.dto.response.OutputItemResponse;
import inventory.control.domain.model.OutputItemModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Component
public class OutputItemMapper {

    public static OutputItemModel toModel(OutpuItemRequest request) {
        return OutputItemModel
                .builder()
                .batch(request.getBatch())
                .amount(request.getAmount())
                .value(request.getValue())
//                .productModel(ProductModel.builder().idProduct(request.getCodProduct()).build())
//                .exitModel(ExitModel.builder().idExit(request.getCodExit()).build())
                .build();
    }

    public static OutputItemResponse toResponse(OutputItemModel outputItemModel) {
        return OutputItemResponse
                .builder()
                .id(outputItemModel.getId())
                .batch(outputItemModel.getBatch())
                .amount(outputItemModel.getAmount())
                .value(outputItemModel.getValue())
//                .productResponse(ProductMapper.toResponse(outputItemModel.getProductModel()))
//                .exitResponse(ExitMapper.toResponse(outputItemModel.getExitModel()))
                .build();
    }

    public static List<OutputItemResponse> toResponseList(List<OutputItemModel> outputItemModelList) {
        if (isNull(outputItemModelList) || outputItemModelList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return outputItemModelList
                    .stream()
                    .map(OutputItemMapper::toResponse)
                    .collect(Collectors.toList());
        }
    }

}
