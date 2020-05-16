package me.celso.agra.service;

import java.util.List;
import java.util.Objects;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import me.celso.agra.model.Information;

@Service
public class InformationReadService {

	@Value("${nitrite.url}")
	private String url;

	@Value("${nitrite.user}")
	private String user;

	@Value("${nitrite.password}")
	private String password;

	private Nitrite db;
	private ObjectRepository<Information> repository;
	
	private ObjectRepository<Information> repository() {
		if (Objects.isNull(repository)) {
			db = Nitrite.builder().compressed().filePath(url).openOrCreate(user, password);
			repository = db.getRepository(Information.class);			
		}
		
		return repository;
	}

	public List<Information> findAll() {
		List<Information> list = Lists.newArrayList();
		repository().find().forEach(list::add);
		return list;
	}

	public boolean add(Information message) {
		Information[] messages = new Information[] { message };
		repository().insert(messages);
		return true;
	}
}
