package dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProductsDto {
    @NotNull
    @NotEmpty
    private String flat_name;
    private String products;

    public String getName() {
        return flat_name;
    }

    public String getProducts() {
        return products;
    }
}
