package info.kurozeropb

import com.github.kurozeropb.CoroutineTimer
import com.intellij.notification.Notification
import com.intellij.notification.NotificationType
import com.intellij.openapi.components.ProjectComponent
import com.intellij.openapi.project.Project
import kotlinx.coroutines.Job

class CommitReminder(private val project: Project) : ProjectComponent {
    private var job: Job? = null

    override fun projectOpened() {
        val notification = Notification("CommitReminder", "Commit Reminder", "Don't forget to commit your new changes", NotificationType.INFORMATION)
        job = CoroutineTimer.interval(0, 1000 * 60 * 30) {
            notification.notify(project)
        }
        super.projectOpened()
    }

    override fun projectClosed() {
        job?.cancel()
        super.projectClosed()
    }

}