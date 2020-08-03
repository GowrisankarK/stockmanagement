package com.project.inventory.stockmanagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.elasticsearch.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.inventory.stockmanagement.model.StockDetail;
import com.project.inventory.stockmanagement.repository.StockRepository;

@RestController
@RequestMapping("/api/stockMangement/v1")
public class StockManagementController {

	@Autowired
	StockRepository stockRepository;
	
	/**
	 * getAllStocks is used to fetch all stock details.
	 * 
	 * @return List<StockDetail>
	 */
	@GetMapping("/stocks")
    public List<StockDetail> getAllStocks() {
        return stockRepository.findAll();
    }
	
	/**
	 * getStockDetailsById is used to fetch the stock details based on stock id.
	 * 
	 * @param id
	 * @return ResponseEntity<StockDetail>
	 */
	@GetMapping("/stocks/{id}")
    public ResponseEntity<StockDetail> getStockDetailsById(@PathVariable(value = "id") Long id)
        throws ResourceNotFoundException {
		StockDetail stockDetail = stockRepository.findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("Stock Details not found for this Stock id :: " + id));
        return ResponseEntity.ok().body(stockDetail);
    }
	
	/**
	 * createStockDetail is used to create new stock.
	 * 
	 * @param stockDetail
	 * @return
	 */
	@PostMapping("/insert/stocks")
    public StockDetail createStockDetail(@RequestBody StockDetail stockDetail) {
        return stockRepository.save(stockDetail);
    }

	/**
	 * updateStockDetail is used to update Detail based on StockId.
	 * 
	 * @param stockId
	 * @param stockDetail
	 * @return
	 * @throws ResourceNotFoundException
	 */
    @PutMapping("/update/stocks/{id}")
    public ResponseEntity<StockDetail> updateStockDetail(@PathVariable(value = "id") Long stockId,
         @RequestBody StockDetail stockDetail) throws ResourceNotFoundException {
    	StockDetail fetchedStockDetail = stockRepository.findById(stockId)
        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + stockId));

    	fetchedStockDetail.setStockName(stockDetail.getStockName());
    	fetchedStockDetail.setStockOwnerId(stockDetail.getStockOwnerId());
    	fetchedStockDetail.setStockOwnerName(stockDetail.getStockOwnerName());
    	fetchedStockDetail.setQuantity(stockDetail.getQuantity());
    	fetchedStockDetail.setStockValue(stockDetail.getStockValue());
    	fetchedStockDetail.setDate(stockDetail.getDate());
    	fetchedStockDetail.setRemarks(stockDetail.getRemarks());
        final StockDetail updatedStockDetail = stockRepository.save(fetchedStockDetail);
        return ResponseEntity.ok(updatedStockDetail);
    }
	
	/**
	 * deleteStockDetailById is used to delete stock details based on id.
	 * 
	 * @param id
	 * @return Map<String, Boolean>
	 */
	@DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteStockDetailById(@PathVariable(value = "id") long id) {
		Map<String,Boolean> deleteStatus = new HashMap<String,Boolean>();
		Optional<StockDetail> optionalStockDetail =stockRepository.findById(id);
		if(optionalStockDetail.isPresent()) {
        stockRepository.deleteById(id);
		deleteStatus.put("status", true);
		} else {
		deleteStatus.put("status", false);
		}
        return deleteStatus;
    }
}
