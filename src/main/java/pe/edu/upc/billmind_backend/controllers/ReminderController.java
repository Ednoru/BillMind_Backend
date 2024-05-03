package pe.edu.upc.billmind_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.billmind_backend.domain.models.Reminder;
import pe.edu.upc.billmind_backend.domain.services.ReminderService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reminders")
public class ReminderController {
    private final ReminderService reminderService;

    @Autowired
    public ReminderController(ReminderService reminderService) {
        this.reminderService = reminderService;
    }

    @GetMapping
    public ResponseEntity<List<Reminder>> getAllReminders() {
        List<Reminder> reminders = reminderService.getAllReminders();
        return new ResponseEntity<>(reminders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reminder> getReminderById(@PathVariable Long id) {
        Reminder reminder = reminderService.getReminderById(id);
        return new ResponseEntity<>(reminder, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Reminder> saveReminder(@RequestBody Reminder reminder) {
        Reminder savedReminder = reminderService.createReminder(reminder);
        return new ResponseEntity<>(savedReminder, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reminder> updateReminder(@RequestBody Reminder reminder) {
        Reminder updatedReminder = reminderService.updateReminder(reminder);
        return new ResponseEntity<>(updatedReminder, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReminder(@PathVariable Long id) {
        reminderService.deleteReminder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
