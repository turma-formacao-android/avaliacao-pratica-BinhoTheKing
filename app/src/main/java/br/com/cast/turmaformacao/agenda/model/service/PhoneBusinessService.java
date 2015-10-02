package br.com.cast.turmaformacao.agenda.model.service;

import java.util.List;

import br.com.cast.turmaformacao.agenda.model.entities.Phone;
import br.com.cast.turmaformacao.agenda.model.persistence.PhoneRepository;

public class PhoneBusinessService {
	public PhoneBusinessService() {
	}

	public static List<Phone> findAll() {
		return PhoneRepository.getAll();
	}

	public static void save(Phone $Phone) {
		PhoneRepository.save($Phone);
	}

	public static void delete(Phone $Phone) {
		PhoneRepository.delete($Phone.getId());
	}

	public static void update(Phone $Phone) {
		PhoneRepository.update($Phone);
	}

	public static void saveOrUpdate(Phone $Phone) {
		if ($Phone.getId() == null || $Phone.getId() == -1) {
			$Phone.setId(null);
			save($Phone);
		} else {
			update($Phone);
		}
	}
}
