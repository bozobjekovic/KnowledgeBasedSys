package bbozo.sbz.webShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bbozo.sbz.webShop.model.ActionEvent;
import bbozo.sbz.webShop.repository.ActionEventRepository;

@Service
public class ActionEventService {

	@Autowired
	ActionEventRepository actionEventRepository;

	public ActionEvent findOne(Long id) {
		return actionEventRepository.findOne(id);
	}

	public List<ActionEvent> findAll() {
		return actionEventRepository.findAll();
	}

	public ActionEvent save(ActionEvent actionEvent) {
		return actionEventRepository.save(actionEvent);
	}

}
