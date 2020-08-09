package com.bidding.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import com.bidding.model.AuctionDetails;

@Repository
public interface AuctionRepository extends MongoRepository<AuctionDetails,String>,QueryByExampleExecutor<AuctionDetails> {

}
