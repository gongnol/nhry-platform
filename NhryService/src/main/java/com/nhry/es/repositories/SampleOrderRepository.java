package com.nhry.es.repositories;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.nhry.data.order.domain.TPreOrder;

public interface SampleOrderRepository extends
		ElasticsearchRepository<TPreOrder, String> {

}
