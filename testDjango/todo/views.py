from django.shortcuts import render
from .models import Tasks
# Create your views here.

def home(request):
	return render(request, 'todo/home.html', {"tasks" : Tasks.objects.all()})


def about(request):
	return render(request, 'todo/about.html', {"title" : "About"})


def contact(request):
	return render(request, 'todo/contact.html', {"title" : "Contact"})