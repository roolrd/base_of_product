package app.model;

import app.entities.Product;
import java.util.ArrayList;
import java.util.List;

public class ModelSingleton
{
    private static ModelSingleton ourInstance = new ModelSingleton();

    private List<Product> model;

    public static ModelSingleton getInstance() {
        return ourInstance;
    }

    private ModelSingleton() {
      model = new ArrayList<>();
    }

    public void add(Product product) {
        model.add(product);
    }

      public List<Product> list() {
        return model;
         }

    // public List<Product> getModel() { return Collections.unmodifiableList( model ); }

    //
    }

