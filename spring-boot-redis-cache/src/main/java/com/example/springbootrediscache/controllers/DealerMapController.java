/**
 * 
 */
package com.example.springbootrediscache.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootrediscache.models.DealerMap;
import com.example.springbootrediscache.models.Search;
import com.example.springbootrediscache.repository.DealerMapRepository;

/**
 * @author Nishant Sonar (qkg5rdk)
 *
 */
@RestController
@RequestMapping("/rest/dealer")
public class DealerMapController {

	@Autowired
	private DealerMapRepository _dealerMapRepository;

	public DealerMapController(DealerMapRepository userRepository) {
		_dealerMapRepository = userRepository;
	}

	@GetMapping("/all/{id}")
	public ResponseEntity<DealerMap> findById(@PathVariable("id") final String id) {
		Optional<DealerMap> dealerMap = _dealerMapRepository.findById(id);
		if (dealerMap.isPresent())
			return new ResponseEntity<DealerMap>(dealerMap.get(), HttpStatus.OK);
		else
			return new ResponseEntity<DealerMap>(new DealerMap(), HttpStatus.NOT_FOUND);
	}

	@GetMapping("/all/dealer/{id}")
	public ResponseEntity<DealerMap> findByDealerId(@PathVariable("id") final String id) {
		Optional<DealerMap> dealerMap = _dealerMapRepository.findById(id);
		if (dealerMap.isPresent())
			return new ResponseEntity<DealerMap>(dealerMap.get(), HttpStatus.OK);
		else
			return new ResponseEntity<DealerMap>(new DealerMap(), HttpStatus.NOT_FOUND);
	}

	@PostMapping("/add")
	public ResponseEntity<DealerMap> add(@RequestBody DealerMap dealerMap) {
		_dealerMapRepository.save(dealerMap);
		return this.findById(dealerMap.getUserId());

	}

	@PostMapping("/search")
	public ResponseEntity<List<DealerMap>> add(@RequestBody Search search) {
		MatchExampleDealerMap matchExampleDealerMap = getExampleMatcher(search);
		Example<DealerMap> example = Example.of(matchExampleDealerMap.getDealerMap(),
				matchExampleDealerMap.getMatcher());
		List<DealerMap> results = StreamSupport.stream(_dealerMapRepository.findAll(example).spliterator(), false)
				.collect(Collectors.toList());
		return new ResponseEntity<List<DealerMap>>(results, HttpStatus.OK);

	}

	private MatchExampleDealerMap getExampleMatcher(Search search) {
		if (!StringUtils.isEmpty(search.getDealerId()) && !StringUtils.isEmpty(search.getUserId())) {
			ExampleMatcher matcher = ExampleMatcher.matching()
					.withStringMatcher(StringMatcher.CONTAINING)
					.withIgnorePaths("id")
					.withMatcher("userId", GenericPropertyMatchers.contains())
					.withMatcher("dealerId", GenericPropertyMatchers.contains());
			DealerMap dealerMap = new DealerMap(search.getUserId(), search.getDealerId());
			MatchExampleDealerMap matchExample = new MatchExampleDealerMap(matcher, dealerMap);
			return matchExample;
		} else if (!StringUtils.isEmpty(search.getUserId())) {
			ExampleMatcher matcher = ExampleMatcher.matching()
					.withStringMatcher(StringMatcher.CONTAINING)
					.withIgnorePaths("id")
					.withIgnorePaths("dealerId")
					.withMatcher("userId", GenericPropertyMatchers.contains());
			DealerMap dealerMap = new DealerMap(search.getUserId(), null);
			MatchExampleDealerMap matchExample = new MatchExampleDealerMap(matcher, dealerMap);
			return matchExample;
		} else if (!StringUtils.isEmpty(search.getDealerId())) {
			ExampleMatcher matcher = ExampleMatcher.matching()
					.withStringMatcher(StringMatcher.CONTAINING)
					.withIgnorePaths("id")
					.withIgnorePaths("userId")
					.withMatcher("dealerId",
					GenericPropertyMatchers.contains());
			DealerMap dealerMap = new DealerMap(null, search.getDealerId());
			MatchExampleDealerMap matchExample = new MatchExampleDealerMap(matcher, dealerMap);
			return matchExample;
		} else {
			return null;
		}
	}
}

class MatchExampleDealerMap {
	ExampleMatcher matcher;
	DealerMap dealerMap;

	public MatchExampleDealerMap(ExampleMatcher matcher, DealerMap dealerMap) {
		super();
		this.matcher = matcher;
		this.dealerMap = dealerMap;
	}

	public ExampleMatcher getMatcher() {
		return matcher;
	}

	public void setMatcher(ExampleMatcher matcher) {
		this.matcher = matcher;
	}

	public DealerMap getDealerMap() {
		return dealerMap;
	}

	public void setDealerMap(DealerMap dealerMap) {
		this.dealerMap = dealerMap;
	}

}