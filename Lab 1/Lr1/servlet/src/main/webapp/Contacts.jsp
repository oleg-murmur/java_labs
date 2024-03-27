<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Contacts</title>

</head>
<body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<div class="container">
    <nav class = "navbar navbar-expand-lg navbar-dark">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item activate">
                <form action="lr1">
                    <button value="1" name="but" class="btn btn-success">
                        Services
                    </button>
                </form>
            </li>
            <li class="nav-item">
                <form action="lr1">
                    <button value="2"  name="but" class="btn btn-success">
                        Contacts
                    </button>
                </form>
            </li>
            <li class="nav-item">
                <form action="lr1">
                    <button value="3" name="but" class="btn btn-success">
                        About us
                    </button>
                </form>
            </li>
            <li class="nav-item ">
                <form action="lr1">
                    <button value="4" name="but" class="btn btn-success">
                        Feedback
                    </button>
                </form>
            </li>
        </ul>
    </nav>
</div>

<div class="row">
    <div class="col-md-6 col-lg-3">
        <ul class="contacts-list contacts-list-work-time">
            <li class="contacts-list-item">
                Пн-пт: 9.00—19.00
            </li>
            <li class="contacts-list-item">
                Сб: 9.00—15.00
            </li>
        </ul>
    </div>
    <div class="col-md-6 col-lg-3">
        <ul class="contacts-list contacts-list-phone">
            <li class="contacts-list-item">
                <a >+7 (3812) 45-22-96</a>
            </li>
            <li class="contacts-list-item">
                <a>+7 (903) 927-83-10</a>
            </li>
        </ul>
    </div>
    <div class="col-md-6 col-lg-3">
        <p class="contacts-list contacts-list-address">
            пр. Ленина, 41
        </p>
    </div>
    <div class="col-md-6 col-lg-3">
        <p class="contacts-list contacts-list-email">
            <a href="mailto:Band@yandex.ru">
                Band@yandex.ru</a>
        </p>
    </div>
</div>

</body>
</html>
