from django.db import models
from django.contrib.auth.models import User
from django.utils import timezone

# Create your models here.
class Tasks(models.Model):
	creator = models.ForeignKey(User, on_delete=models.CASCADE)
	title = models.CharField(max_length=50)
	content = models.TextField()
	date_added = models.DateTimeField()

	def __str__(self):
		return self.title
	