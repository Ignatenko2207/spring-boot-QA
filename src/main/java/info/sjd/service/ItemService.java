package info.sjd.service;

import info.sjd.dao.ItemDAO;
import info.sjd.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    ItemDAO itemDAO;

    public Item save(Item item){
        if (itemDAO.findById(item.getId()) == null){
            return itemDAO.save(item);
        }
        return null;
    }

    public Item update(Item item){
        if (itemDAO.findById(item.getId()) != null){
            return itemDAO.save(item);
        }
        return null;
    }

    public Item findById(Integer id){
        return itemDAO.findById(id).get();
    }

    public void deleteById(Integer id){
        itemDAO.deleteById(id);
    }
}
