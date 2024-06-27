package za.ac.cput.factory;

import za.ac.cput.domain.Ingredient;
import za.ac.cput.domain.StockOrder;
import za.ac.cput.domain.Supplier;

import java.util.List;

public class StockOrderFactory {

    public static StockOrder buildStockOrder(List<Ingredient> ingredients, int units, double total, boolean fulfilled, Supplier supplier){
        if(!ingredients.isEmpty() && units > 0 && total > 0 && supplier != null){
            return new StockOrder.Builder()
                    .setIngredients(ingredients)
                    .setUnits(units)
                    .setTotal(total)
                    .setFulfilled(fulfilled)
                    .setSupplier(supplier).build();
        }
        return null;
    }
    public static StockOrder buildStockOrder(long id, List<Ingredient> ingredients, int units, double total, boolean fulfilled, Supplier supplier){
        if(!ingredients.isEmpty() && units > 0 && total > 0 && supplier != null){
            return new StockOrder.Builder()
                    .setId(id)
                    .setIngredients(ingredients)
                    .setUnits(units)
                    .setTotal(total)
                    .setFulfilled(fulfilled)
                    .setSupplier(supplier).build();
        }
        return null;
    }
}
