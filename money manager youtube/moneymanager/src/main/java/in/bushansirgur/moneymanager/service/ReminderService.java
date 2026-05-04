package in.bushansirgur.moneymanager.service;

import in.bushansirgur.moneymanager.entity.ProfileEntity;
import in.bushansirgur.moneymanager.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReminderService {

    private final ProfileRepository profileRepository;
    private final EmailService emailService;

    // Runs every day at 10 PM
    @Scheduled(cron = "0 * * * * *")
    public void sendDailyReminder() {

        List<ProfileEntity> profiles = profileRepository.findAll();

        for (ProfileEntity profile : profiles) {

            if (profile.getIsActive() != null && profile.getIsActive()) {

                String subject = "Money Manager Reminder";

                String body = "Hello " + profile.getFullName()
                        + ",\n\nDon't forget to add today's income or expenses in Money Manager.\n\nThank you!";

                emailService.sendEmail(profile.getEmail(), subject, body);
            }
        }
    }
}