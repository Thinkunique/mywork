package com.bidding.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import com.bidding.model.BiddingDetails;


@Repository
public interface BiddingRepository extends MongoRepository<BiddingDetails,String>,QueryByExampleExecutor<BiddingDetails> {	
	
}
