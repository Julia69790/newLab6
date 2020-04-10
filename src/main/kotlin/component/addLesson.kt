package component

import kotlinx.html.InputType
import kotlinx.html.id
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.events.Event
import react.RBuilder
import react.RProps
import react.child
import react.dom.*
import react.functionalComponent
import kotlin.browser.document

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


