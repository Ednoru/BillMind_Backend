package pe.edu.upc.billmind_backend.domain.services;

import org.springframework.stereotype.Service;
import pe.edu.upc.billmind_backend.domain.models.Client;
import pe.edu.upc.billmind_backend.domain.models.Reminder;
import pe.edu.upc.billmind_backend.domain.repositories.ReminderRepository;

import java.util.List;

@Service
public class ReminderService {
    private final ReminderRepository reminderRepository;

    public ReminderService(ReminderRepository reminderRepository) {
        this.reminderRepository = reminderRepository;
    }

    public List<Reminder> getAllReminders() {
        return reminderRepository.findAll();
    }

    public List<Reminder> getRemindersByClientId(Client clientId) {
        return reminderRepository.findByClientId(clientId);
    }

    public Reminder createReminder(Reminder reminder) {
        return reminderRepository.save(reminder);
    }

    public Reminder updateReminder(Reminder reminder) {
        return reminderRepository.save(reminder);
    }

    public void deleteReminder(Long reminderId) {
        reminderRepository.deleteById(reminderId);
    }

    public Reminder getReminderById(Long reminderId) {
        return reminderRepository.findById(reminderId).orElse(null);
    }
}
