package dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProductsDto {
    @NotNull
    @NotEmpty
    private String name;
    private String products;

    public String getName() {
        return name;
    }

    public String getProducts() {
        return products;
    }
}
