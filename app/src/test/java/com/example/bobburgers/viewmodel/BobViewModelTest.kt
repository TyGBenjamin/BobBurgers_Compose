package com.example.bobburgers.viewmodel

import com.example.bobburgers.model.entity.Bobcharacter
import com.example.bobburgers.model.remote.BobRepo
import com.example.bobburgers.utilTest.CoroutinesTestExtension
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension

internal class BobViewModelTest {
    @RegisterExtension
    private val coroutinesTestExtension = CoroutinesTestExtension()
    private val repo = mockk<BobRepo>()

    @Test
    @DisplayName("Testing if repo returns list of cahracter are loading")
    fun testViewModel() = runTest(coroutinesTestExtension.dispatcher) {
        // Given
        val chars = emptyList<Bobcharacter>()
        coEvery { repo.getCharacters() as List<Bobcharacter> } coAnswers { chars }

        // When
        val vm = BobViewModel(repo)
        val state = vm.homeState.value

        // Then
        assertFalse(state.isLoading)
        assertEquals(chars, state.characters)
    }
}
