# newLab6
## Задание: 
Доработайте приложение из видео. Перенесите массив lessons из AppProps в AppState. 
Добавьте компонент AddLesson, который позволяет добавить урок в массив lessons. 
Другие компоненты (кроме App и AddLesson) не должны изменяться, но должны корректно работать.
## Выполнение работы
1. Добавлен функциональный компонент addLesson, в свойствах которого содержится функция click. Функция нужна, чтобы обновить состояние app при добавлении урока.Компонент содержит 2 тега input, первый – text, нужен для того, что создать поле, в которое
пользователь вводит новый урок; второй – button, т.е. кнопка, с помощью которой пользователь сообщает о том, что нужно добавить 
новый урок.<br>
Код компонента:
        
        interface addLessonProps : RProps{
        var click: (Event)->Unit
        }
        
        val faddLesson =
          functionalComponent<addLessonProps>{
        h2{+ "Add Lesson" }
            input(InputType.text) {}
            input(InputType.button) {
                attrs.value = "Добавить"
                attrs.onClickFunction = it.click
            }
        }
        
        fun RBuilder.addLesson(
        click:(Event)->Unit
        ) = child(faddLesson){
         attrs.click = click
        }
2. В арр lessons перенесен в состояние, в render вызывается addLesson(click()), добавлена функция click(). В функции вызывается getElementsByTagName, 
где в качестве аргумента выступает input. Этот метод вызвращает все элементы с указанным тегом. Так как первым записан input text, указано, что
нужно взять элемент [0]. Далее берется значение, которое ввел пользователь в соответствующее поле. setState позволяет изменить состояние компонента.
К массиву lessons добавляет новый урок, а к двумерному массиву presents добавляет еще одну группу со значением false, так как для нового урока тоже нужны данные о присутствии студентов.<br>
Код функции click():
         
        fun click() = {_: Event ->
        val myinput =  document.getElementsByTagName("input")[0]!! as HTMLInputElement
            val extraLesson = Lesson("${myinput.value}")
            setState {
                lessons += extraLesson
                presents += arrayOf(arrayOf(false, false, false))
            }
        }
        
Программа после запуска:<br>![](/screen6/запуск.png)<br>
Добавление урока:<br>![](/screen6/добавление.png)<br>
![](/screen6/добавление2.png)<br>
Проверка корректной работы(добавили еще один урок, отметили некоторых студентов присутствующими): ![](/screen6/корректность.png)<br>
