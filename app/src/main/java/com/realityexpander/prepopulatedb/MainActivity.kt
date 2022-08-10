package com.realityexpander.prepopulatedb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.realityexpander.prepopulatedb.ui.theme.PrePopulateDBTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PrePopulateDBTheme {
                val result by mainViewModel.readAll.collectAsState(initial = emptyList())

                Column (
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if(result.isNotEmpty()) {
                        for(person in result) {
                            Text(
                                text = person.firstName + " " + person.lastName,
                                modifier = Modifier.padding(16.dp),
                                fontSize = MaterialTheme.typography.h4.fontSize
                            )
                        }
                        Text(text = "Read all: ${result.size}")
                    } else {
                        Text(text = "Read all: Empty")
                    }
                }
            }
        }
    }
}

