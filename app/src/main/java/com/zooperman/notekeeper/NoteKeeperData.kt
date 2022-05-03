package com.zooperman.notekeeper

class CourseInfo(val courseId: String, val courseTitle: String) {
    override fun toString(): String {
        return courseTitle
    }
}

class NoteInfo(var course: CourseInfo, var title: String, var text: String)