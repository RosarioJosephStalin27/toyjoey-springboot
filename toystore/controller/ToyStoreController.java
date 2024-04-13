package com.example.toystore.toystore.controller;

import com.example.toystore.toystore.model.OrderDetails;
import com.example.toystore.toystore.model.Toy;
import com.example.toystore.toystore.model.ToyStore;
import com.example.toystore.toystore.service.ToyStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/toystores")
public class ToyStoreController {

    @Autowired
    private ToyStoreService toyStoreService;

    @GetMapping
    public List<ToyStore> getAllToyStores() {
        return toyStoreService.getAllToyStores();
    }

    @GetMapping("/{id}")
    public ToyStore getToyStoreById(@PathVariable Long id) {
        return toyStoreService.getToyStoreById(id);
    }

    @PostMapping
    public ToyStore createToyStore(@RequestBody ToyStore toyStore) {
        return toyStoreService.createToyStore(toyStore);
    }

    @PutMapping("/{id}")
    public ToyStore updateToyStore(@PathVariable Long id, @RequestBody ToyStore toyStore) {
        return toyStoreService.updateToyStore(id, toyStore);
    }

    @DeleteMapping("/{id}")
    public void deleteToyStore(@PathVariable Long id) {
        toyStoreService.deleteToyStore(id);
    }

    @PostMapping("/Toy/{toystoreId}/create")
    public ResponseEntity<Toy> createToy(@PathVariable Long ToyStoreId, @RequestBody Toy toy) throws NotFoundException {
        ToyStore toystore = toyStoreService.getUserById1(ToyStoreId);
        if (toystore == null) {
            // Handle the case where the order does not exist
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Set the order for the order item
        toy.setToyStore(toystore);
        Toy savedOrderItem =toyStoreService.createToy(toy);
        return new ResponseEntity<>(savedOrderItem, HttpStatus.CREATED);
    }
    @PostMapping("/OrderDetails/{toystoreId}/create")
    public ResponseEntity<OrderDetails> createOrder(@PathVariable Long ToyStoreId, @RequestBody OrderDetails orderDetails) throws NotFoundException {
        ToyStore toystore = toyStoreService.getUserById1(ToyStoreId);
        if (toystore == null) {
            // Handle the case where the order does not exist
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Set the order for the order item
        orderDetails.setToyStore(toystore);
        OrderDetails savedOrderItem =toyStoreService.createOrder(orderDetails);
        return new ResponseEntity<>(savedOrderItem, HttpStatus.CREATED);
    }
    @GetMapping("/api/children/sortBy/{field}")
    public ResponseEntity<?> getchild(@PathVariable String field)
    {
        try
        {
            return new ResponseEntity<>(toyStoreService.getchild(field),HttpStatus.OK);
        }catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/children/{offset}/{pagesize}")
    public ResponseEntity<?> gettchild(@PathVariable int offset,@PathVariable int pagesize)
    {
        try
        {
            return new ResponseEntity<>(toyStoreService.gettchild(offset,pagesize),HttpStatus.OK);
        }catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/children/{offset}/{pagesize}/{field}")
    public ResponseEntity<?> getttchild(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field)
    {
        try
        {
            return new ResponseEntity<>(toyStoreService.getttchild(offset,pagesize,field),HttpStatus.OK);
        }catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

   


