package com.example.todoapp.ui.presentation.task_screen

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import org.koin.androidx.compose.koinViewModel
import com.example.todoapp.R
import com.example.todoapp.ui.presentation.components.*
import com.example.todoapp.ui.presentation.todo.TodoEffect
import com.example.todoapp.ui.presentation.todo.TodoIntent
import com.example.todoapp.ui.utils.Utils.formatTime


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TasksScreen(
    navController: NavHostController,
    viewModel: TodoViewModel = koinViewModel()
) {

    val state by viewModel.uiState.collectAsStateWithLifecycle()

    val context = LocalContext.current


    var showBottomSheet by remember {
        mutableStateOf(true)
    }

    var showDatePicker by remember {
        mutableStateOf(false)
    }

    var showTimePicker by remember {
        mutableStateOf(false)
    }


    val sheetState = rememberModalBottomSheetState()

    val datePickerState = rememberDatePickerState()

    val timePickerState = rememberTimePickerState(
        initialHour = 12,
        initialMinute = 0,
        is24Hour = false
    )


    // Effects
    LaunchedEffect(Unit) {

        viewModel.effect.collect { effect ->

            when(effect) {

                is TodoEffect.ShowToast -> {

                    Toast.makeText(
                        context,
                        effect.message,
                        Toast.LENGTH_SHORT
                    ).show()

                }
            }
        }
    }


    Scaffold(

        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        colorResource(R.color.bg_top_color),
                        colorResource(R.color.bg_bottom_color)
                    )
                )
            ),

        floatingActionButton = {

            FloatingActionButton(
                onClick = {
                    showBottomSheet = true
                },
                containerColor = colorResource(R.color.fab_color)
            ) {

                Image(
                    painter = painterResource(R.drawable.plus_icon),
                    contentDescription = null
                )
            }
        },

        containerColor = Color.Transparent

    ) { padding ->


        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {


            // DATE PICKER

            if(showDatePicker){

                DatePickerDialog(

                    onDismissRequest = {
                        showDatePicker = false
                    },

                    confirmButton = {

                        TextButton(
                            onClick = {

                                datePickerState
                                    .selectedDateMillis
                                    ?.let {

                                        viewModel.onIntent(
                                            TodoIntent.DateSelected(it)
                                        )
                                    }


                                showDatePicker=false
                            }
                        ){

                            Text("OK")
                        }
                    },

                    dismissButton = {

                        TextButton(
                            onClick = {
                                showDatePicker=false
                            }
                        ){

                            Text("Cancel")
                        }
                    }

                ){

                    DatePicker(
                        state = datePickerState
                    )
                }
            }



            // TIME PICKER

            if(showTimePicker){

                AlertDialog(

                    onDismissRequest = {
                        showTimePicker=false
                    },

                    confirmButton = {

                        TextButton(
                            onClick = {


                                val time = formatTime(
                                    timePickerState.hour,
                                    timePickerState.minute
                                )


                                viewModel.onIntent(
                                    TodoIntent.TimeSelected(time)
                                )


                                showTimePicker=false
                            }
                        ){

                            Text("OK")
                        }
                    },


                    dismissButton = {

                        TextButton(
                            onClick = {
                                showTimePicker=false
                            }
                        ){

                            Text("Cancel")
                        }
                    },


                    text = {

                        TimePicker(
                            state = timePickerState
                        )
                    }
                )
            }




            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp)
            ) {


                Spacer(
                    modifier = Modifier.height(40.dp)
                )


                Text(
                    text = "Tasks list",
                    color = Color.White,
                    fontSize = 22.sp
                )

            }



            // BOTTOM SHEET

            if(showBottomSheet){


                ModalBottomSheet(

                    onDismissRequest = {
                        showBottomSheet=false
                    },

                    sheetState = sheetState,

                    containerColor = Color.White

                ){


                    Column(

                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)

                    ){



                        TaskTitleTextField(

                            value = state.title,

                            onValueChange = {

                                viewModel.onIntent(
                                    TodoIntent.TitleChanged(it)
                                )
                            },

                            hint = "Task title..."

                        )



                        Spacer(
                            Modifier.height(10.dp)
                        )



                        SheetTextField(

                            value = state.description,

                            onValueChange = {

                                viewModel.onIntent(
                                    TodoIntent.DescriptionChanged(it)
                                )
                            },

                            hint = "Task description..."

                        )



                        Spacer(
                            Modifier.height(10.dp)
                        )



                        Row(

                            modifier = Modifier.fillMaxWidth(),

                            horizontalArrangement = Arrangement.Center

                        ){

                            CustomSheetButton(

                                text = "Date",

                                icon = R.drawable.calender_ic,

                                onClick = {
                                    showDatePicker=true
                                }
                            )


                            Spacer(
                                Modifier.width(10.dp)
                            )


                            CustomSheetButton(

                                text = "Time",

                                icon = R.drawable.clock_ic,

                                onClick = {
                                    showTimePicker=true
                                }
                            )
                        }



                        Spacer(
                            Modifier.height(30.dp)
                        )



                        Row(

                            modifier = Modifier.fillMaxWidth(),

                            horizontalArrangement = Arrangement.Center

                        ){



                            Button(

                                onClick = {
                                    showBottomSheet=false
                                },

                                border = BorderStroke(
                                    2.dp,
                                    colorResource(R.color.btn_border_color)
                                ),

                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.White
                                ),

                                modifier = Modifier.size(
                                    170.dp,
                                    45.dp
                                )

                            ){

                                Text(
                                    "Cancel",
                                    color = Color.Black
                                )
                            }



                            Spacer(
                                Modifier.width(10.dp)
                            )



                            Button(

                                onClick = {

                                    viewModel.onIntent(
                                        TodoIntent.SaveTodo
                                    )

                                },

                                modifier = Modifier.size(
                                    170.dp,
                                    45.dp
                                ),

                                colors = ButtonDefaults.buttonColors(
                                    containerColor =
                                        colorResource(R.color.btn_border_color)
                                )

                            ){

                                Text(
                                    "Create",
                                    color = Color.White
                                )
                            }
                        }


                        Spacer(
                            Modifier.height(20.dp)
                        )

                    }
                }
            }
        }
    }
}