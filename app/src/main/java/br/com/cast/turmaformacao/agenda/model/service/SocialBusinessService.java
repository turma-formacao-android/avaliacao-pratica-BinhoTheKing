package br.com.cast.turmaformacao.agenda.model.service;

import java.util.List;

import br.com.cast.turmaformacao.agenda.model.entities.Social;
import br.com.cast.turmaformacao.agenda.model.persistence.SocialRepository;

public class SocialBusinessService {
	public SocialBusinessService() {
	}

	public static List<Social> findAll() {
		return SocialRepository.getAll();
	}

	public static void save(Social $Social) {
		SocialRepository.save($Social);
	}

	public static void delete(Social $Social) {
		SocialRepository.delete($Social.getId());
	}

	public static void update(Social $Social) {
		SocialRepository.update($Social);
	}

	public static void saveOrUpdate(Social $Social) {
		if ($Social.getId() == null || $Social.getId() == -1) {
			$Social.setId(null);
			save($Social);
		} else {
			update($Social);
		}
	}
}
