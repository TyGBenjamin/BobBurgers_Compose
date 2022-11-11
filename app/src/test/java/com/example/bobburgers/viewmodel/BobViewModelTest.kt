package com.example.bobburgers.viewmodel

import com.example.bobburgers.model.entity.Bobcharacter
import com.example.bobburgers.model.remote.BobRepo
import com.example.bobburgers.utilTest.CoroutinesTestExtension
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension

/**
 * Bob view model test
 *
 * @constructor Create empty Bob view model test
 */
internal class BobViewModelTest{
    @RegisterExtension
    private val coroutinesTestExtension = CoroutinesTestExtension()
    private val repo = mockk<BobRepo>()

    @Test
    @DisplayName("Testing the state of viewmodel when cards are loading")
    fun testViewModel() = runTest(coroutinesTestExtension.dispatcher) {
        // Given
        val list = emptyList<Bobcharacter>()
        coEvery { repo.getCharacters() as List<Bobcharacter> } coAnswers { list }

        // When
        val vm = BobViewModel(repo)
        val state = vm.homeState.value
        // Then
        assertFalse(state.isLoading)
        assertEquals(list, state.characters)
    }
}
