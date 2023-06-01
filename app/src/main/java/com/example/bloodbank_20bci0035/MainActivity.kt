package com.example.bloodbank_20bci0035

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.ClipData.Item
import android.graphics.drawable.Icon
import android.os.Bundle
import android.widget.DatePicker
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
//import androidx.compose.foundation.gestures.ModifierLocalScrollableContainerProvider.value
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bloodbank_20bci0035.ui.theme.BloodBank_20BCI0035Theme


//This text was added through github
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BloodBank_20BCI0035Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    bloodBank()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BloodBank_20BCI0035Theme {
        Greeting("Android")
    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun bloodBank(){
    Scaffold(
        topBar = { CustomTopBar() },
        content = {MainContent()}
    ) 
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(){
    TopAppBar(
        title ={
            Row(
                verticalAlignment =Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 50.dp)
            ){
                androidx.compose.material3.Icon(painter = painterResource(id = R.drawable.img),
                    contentDescription = "blood icon")
                androidx.compose.material3.Icon(painter = painterResource(id = R.drawable.img_1),
                    contentDescription = "doctor icon")
                var abc by remember {
                    mutableStateOf(false)
                }
                Box() {
                    IconButton(onClick = { abc= !abc }) {
                        androidx.compose.material3.Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "icon for menu"
                        )
                    }
                    DropdownMenu(expanded = abc , onDismissRequest = { abc=false }) {
                        DropdownMenuItem(text = { Text("Home") }, onClick = { /*TODO*/ })
                        DropdownMenuItem(text = { Text("Our Website") }, onClick = { /*TODO*/ })
                        DropdownMenuItem(text = { Text("About Us") }, onClick = { /*TODO*/ })

                    }

                }


            }

        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Red)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(top = 100.dp)

    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painterResource(id = R.drawable.img_2),
                contentDescription =
                "blood logo",
                modifier = Modifier.size(width = 220.dp, height = 100.dp)

            )

        }
        Column(modifier = Modifier.padding(start = 30.dp)) {
            Text(
                "All India Blood Bank Association",
//                color = Color.Blue,
//                fontFamily =
//                FontFamily.SansSerif,
//                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            val firstName = remember {
                mutableStateOf("")
            }
            val lastName = remember {
                mutableStateOf("")
            }
            val bloodGroup = remember {
                mutableStateOf("")
            }
            Spacer(modifier = Modifier.height(40.dp))
            Text(text = "Name: ")
            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                TextField(
                    value = firstName.value, onValueChange = { firstName.value = it }, modifier
                    = Modifier
                        .width(150.dp)
                        .padding(20.dp)
                )
                TextField(
                    value = lastName.value, onValueChange = { lastName.value = it }, modifier
                    = Modifier
                        .width(150.dp)
                        .padding(20.dp)
                )
            }

            Text(text = "Blood type")
            TextField(
                value = bloodGroup.value, onValueChange = { bloodGroup.value = it }, modifier
                = Modifier
                    .size(90.dp)
                    .padding(20.dp)
            )
            Text(text = "Date of Birth")
            val datePicker = DatePickerDialog(LocalContext.current)
            FloatingActionButton(onClick = { datePicker.show() }) {
                androidx.compose.material3.Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = "icon"
                )
            }

            Spacer(modifier = Modifier.height(40.dp))



            Spacer(modifier = Modifier.height(30.dp))

        }


    }

}
