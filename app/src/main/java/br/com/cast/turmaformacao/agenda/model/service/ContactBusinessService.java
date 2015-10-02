package br.com.cast.turmaformacao.agenda.model.service;

import java.util.List;

import br.com.cast.turmaformacao.agenda.model.entities.Contact;
import br.com.cast.turmaformacao.agenda.model.persistence.ContactRepository;

public class ContactBusinessService {
	public ContactBusinessService() {
	}

	public static List<Contact> findAll() {
		return ContactRepository.getAll();
	}

	public static void save(Contact $Contact) {
		ContactRepository.save($Contact);
	}

	public static void delete(Contact $Contact) {
		ContactRepository.delete($Contact.getId());
	}

	public static void update(Contact $Contact) {
		ContactRepository.update($Contact);
	}

	public static void saveOrUpdate(Contact $Contact) {
		if ($Contact.getId() == null || $Contact.getId() == -1) {
			$Contact.setId(null);
			save($Contact);
		} else {
			update($Contact);
		}
	}
}
