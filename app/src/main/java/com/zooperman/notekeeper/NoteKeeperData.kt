package com.zooperman.notekeeper

data class CourseInfo(val courseId: String, val courseTitle: String) {
    override fun toString(): String {
        return courseTitle
    }
}

data class NoteInfo(var course: CourseInfo, var title: String, var text: String)