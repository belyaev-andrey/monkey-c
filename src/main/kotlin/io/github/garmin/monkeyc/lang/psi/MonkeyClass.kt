package io.github.garmin.monkeyc.lang.psi

interface MonkeyClass : MonkeyComponent {
    fun getBodyMembers(): MonkeyClassBodyMembers?
}