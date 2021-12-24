package com.hapon.shop.web.controller;

import com.hapon.shop.domain.PurchaseDom;
import com.hapon.shop.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/all")
    public ResponseEntity<List<PurchaseDom>> getAll() {
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/client/{idClient}")
    public ResponseEntity<List<PurchaseDom>> getByClient(@PathVariable("idClient") String clientId) {
        return purchaseService.getByClient(clientId).map(
                purchases -> new ResponseEntity<>(purchases, HttpStatus.OK)
        ).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<PurchaseDom> save(@RequestBody PurchaseDom purchase) {
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
    }
}