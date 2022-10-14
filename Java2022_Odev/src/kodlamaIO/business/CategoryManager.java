package kodlamaIO.business;

import kodlamaIO.core.Logger;
import kodlamaIO.dataAccess.CategoryDao;
import kodlamaIO.entities.Category;

import java.util.List;

public class CategoryManager {
    private CategoryDao categoryDao;
    private Logger[] loggers;
    private List<Category> categories;

    public CategoryManager(CategoryDao categoryDao, Logger[] loggers, List<Category> categories) {
        this.categoryDao=categoryDao;
        this.loggers=loggers;
        this.categories=categories;

    }
    public void add(Category category) throws Exception{
        for(Category category1 :categories ){
            if (category1.getCategoryName()==category.getCategoryName()){
                throw new Exception("Girdiginiz kategori adi kullanilmakta, lutfen baska bir kategori adi giriniz! ");
            }
        }
        categoryDao.add(category);

        for (Logger logger: loggers){
            logger.log(category.getCategoryName());
        }
    }

}
