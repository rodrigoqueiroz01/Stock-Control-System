package inventory.control.api.mapper;

import inventory.control.api.dto.request.ExitRequest;
import inventory.control.api.dto.response.ExitResponse;
import inventory.control.domain.model.ExitModel;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.Objects.isNull;

@Component
public class ExitMapper {

    public static ExitModel toModel(ExitRequest request) {
        return ExitModel
                .builder()
                .total(request.getTotal())
                .shipping(request.getShipping())
                .tax(request.getTax())
//                .conveyorModels(ConveyorMapper.toModelList(request.getCodConveyorList()))
//                .storeModel(StoreModel.builder().idStore(request.getCodStore()).build())
                .build();
    }

    public static ExitResponse toResponse(ExitModel exitModel) {
        return ExitResponse
                .builder()
                .id(exitModel.getId())
                .total(exitModel.getTotal())
                .shipping(exitModel.getShipping())
                .tax(exitModel.getTax())
//                .storeResponse(StoreMapper.toResponse(exitModel.getStoreModel()))
                .build();
    }

    public static List<ExitResponse> toResponseList(List<ExitModel> exitModelList) {
        if (isNull(exitModelList) || exitModelList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return exitModelList
                    .stream()
                    .map(ExitMapper::toResponse)
                    .collect(Collectors.toList());
        }
    }

}
