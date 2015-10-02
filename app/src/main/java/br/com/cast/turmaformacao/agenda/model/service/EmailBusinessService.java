package br.com.cast.turmaformacao.agenda.model.service;

import java.util.List;

import br.com.cast.turmaformacao.agenda.model.entities.Email;
import br.com.cast.turmaformacao.agenda.model.persistence.EmailRepository;

public class EmailBusinessService {
	public EmailBusinessService() {
	}

	public static List<Email> findAll() {
		return EmailRepository.getAll();
	}

	public static void save(Email $Email) {
		EmailRepository.save($Email);
	}

	public static void delete(Email $Email) {
		EmailRepository.delete($Email.getId());
	}

	public static void update(Email $Email) {
		EmailRepository.update($Email);
	}

	public static void saveOrUpdate(Email $Email) {
		if ($Email.getId() == null || $Email.getId() == -1) {
			$Email.setId(null);
			save($Email);
		} else {
			update($Email);
		}
	}
}
