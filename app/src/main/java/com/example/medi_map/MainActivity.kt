import android.os.Build
import android.os.Bundle
import android.widget.DatePicker
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.navigation.NavController
import androidx.navigation.compose.*
import com.example.medi_map.ui.theme.Medi_mapTheme
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Surface
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Calendar
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import com.example.medi_map.R



class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Medi_mapTheme {
                MediMapApp()
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MediMapApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "registration") {
        composable("registration") { SignUpScreen(navController) }
        composable("doctorDirectory") { DoctorDirectoryScreen(navController) }
        composable("scheduleAppointment") { AppointmentScheduleScreen(navController) }
        composable("bedBooking") { BedBookingScreen(navController) }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Top wavy shape
        Canvas(modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)) {
            val width = size.width
            val height = size.height
            val path = Path().apply {
                moveTo(0f, height * 0.5f)
                quadraticBezierTo(width * 0.5f, height * 0.8f, width, height * 0.2f)
                lineTo(width, 0f)
                lineTo(0f, 0f)
                close()
            }
            drawPath(path, color = Color(0xFF74BFB8)) // Adjusted color
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(150.dp))

            // Title
            Text(
                text = "MediMap",
                style = TextStyle(
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF000000) // Black text for title
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Welcome Text
            Text(
                text = "Welcome!\nCreate Your Account",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF00796B) // Dark teal
                ),
                modifier = Modifier.padding(bottom = 16.dp),
                lineHeight = 24.sp
            )

            // Email Input Field
            OutlinedTextField(
                value = "",
                onValueChange = { /* Handle Email input */ },
                label = { Text("Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF00796B),
                    unfocusedBorderColor = Color(0xFF74BFB8)
                ),
                leadingIcon = {
                    Icon(Icons.Default.Email, contentDescription = "Email Icon")
                },
                textStyle = TextStyle(color = Color(0xFF00796B)) // Text color for input
            )

            // Password Input Field
            OutlinedTextField(
                value = "",
                onValueChange = { /* Handle Password input */ },
                label = { Text("Password") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF00796B),
                    unfocusedBorderColor = Color(0xFF74BFB8)
                ),
                leadingIcon = {
                    Icon(Icons.Default.Lock, contentDescription = "Password Icon")
                },
                textStyle = TextStyle(color = Color(0xFF00796B)), // Text color for input
                visualTransformation = PasswordVisualTransformation() // Password hide input
            )

            // Forgot Password and Sign up prompts
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Forgot Password?",
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = Color(0xFF00796B) // Dark teal
                    )
                )
                Text(
                    text = "Not a patient? Click here.",
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = Color(0xFF00796B) // Dark teal
                    )
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Sign-Up Button
            Button(
                onClick = { /* Handle Sign Up click */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00796B))
            ) {
                Text(text = "Sign Up", color = Color.White)
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Social Media Sign in
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                IconButton(onClick = { /* Google Sign in */ }) {
                    Image(
                        painter = painterResource(id = R.drawable.googlesignin),
                        contentDescription = "Google Icon"
                    )
                }
                IconButton(onClick = { /* Facebook Sign in */ }) {
                    Image(
                        painter = painterResource(id = R.drawable.facebookicon),
                        contentDescription = "Facebook Icon"
                    )
                }
                IconButton(onClick = { /* Apple Sign in */ }) {
                    Image(
                        painter = painterResource(id = R.drawable.applesignin),
                        contentDescription = "Apple Icon"
                    )
                }
            }
        }

        // Bottom wavy shape
        Canvas(modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .align(Alignment.BottomCenter)) {
            val width = size.width
            val height = size.height
            val path = Path().apply {
                moveTo(0f, height * 0.7f)
                quadraticBezierTo(width * 0.5f, height * 1.2f, width, height * 0.5f)
                lineTo(width, height)
                lineTo(0f, height)
                close()
            }
            drawPath(path, color = Color(0xFF00796B)) // Adjusted color for bottom wave
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DoctorDirectoryScreen(navController: NavController) {
    // Main column for layout structure
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFFF8F8F8))
    ) {
        // Top Row with Title and User Profile
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "MediMap",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text("Justin Nguyen", style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Bold)
                Text("Male, 18", style = MaterialTheme.typography.bodySmall, color = Color.Gray)
            }

            // Profile Picture
            Image(
                painter = painterResource(id = R.drawable.useric), // Replace with actual avatar resource
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Information Card (Get the best care section)
        Card(
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF009688)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Get the best care.\nAt a hospital near you.",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Search Field (Try 'Dermatologist')
                OutlinedTextField(
                    value = "",
                    onValueChange = { /* Handle search */ },
                    label = {
                        Text(
                            "Try 'Dermatologist'",
                            color = Color.Gray.copy(alpha = 0.75F) // Adjusted for better visibility
                        )
                    },
                    leadingIcon = {
                        Icon(Icons.Filled.Search, contentDescription = "Search Icon", tint = Color.White)
                    },

                    trailingIcon = {
                        Icon(
                            Icons.Default.Call,
                            contentDescription = "Voice Search Icon",
                            modifier = Modifier.size(24.dp),
                            tint = Color.White
                        )
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.Gray.copy(alpha = 0.5F), // Lighten the border when not focused
                        cursorColor = Color.White,
                        containerColor = Color.Transparent // Ensure no background to mess with custom shapes
                    ),
                    textStyle = TextStyle(color = Color.White),

                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Medicine Dispensary Section
        Card(
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF00BFA5)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Medicine Dispensary",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Get your medicines directly on the app now!",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White
                    )
                }

                Icon(
                    imageVector = Icons.Filled.ArrowForward,
                    contentDescription = "Dispensary Icon",
                    tint = Color.White,
                    modifier = Modifier.size(32.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Available Doctors Nearby Section
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Available Doctors Nearby",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "View More",
                style = MaterialTheme.typography.bodySmall,
                color = Color(0xFF009688)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Doctors List (LazyRow)
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                DoctorCard(
                    doctorName = "Dr. R.Ravindran",
                    specialty = "Pediatrician",
                    rating = 5.0,
                    image = painterResource(id = R.drawable.doctor1) // Replace with actual image
                )
            }
            item {
                DoctorCard(
                    doctorName = "Dr. Kriti Sen",
                    specialty = "Cardiologist",
                    rating = 4.5,
                    image = painterResource(id = R.drawable.doctor2) // Replace with actual image
                )
            }
        }
    }
}

@Composable
fun DoctorCard(doctorName: String, specialty: String, rating: Double, image: Painter) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .width(200.dp)
            .clickable { /* Navigate to Doctor Details */ }
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = image,
                contentDescription = "$doctorName Image",
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = doctorName,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = specialty,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Filled.Star, contentDescription = "Rating Star", tint = Color(0xFFFFD700))
                Text(
                    text = rating.toString(),
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppointmentScheduleScreen(navController: NavController) {
    var selectedDate by remember { mutableStateOf(LocalDate.now()) }

    // Formatter for date display
    val dateFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy")

    // Define a cyan color scheme
    val cyanColorScheme = lightColorScheme(
        primary = Color(0xFF00BCD4), // Cyan
        onPrimary = Color.White,
        primaryContainer = Color(0xFFB2EBF2), // Lighter Cyan
        onPrimaryContainer = Color.Black,
        secondary = Color(0xFF00ACC1), // Darker Cyan
        onSecondary = Color.White,
        secondaryContainer = Color(0xFFB2EBF2), // Lighter Cyan
        onSecondaryContainer = Color.Black,
        background = Color(0xFFE0F7FA), // Light Cyan Background
        onBackground = Color.Black,
        surface = Color.White,
        onSurface = Color.Black,
        surfaceVariant = Color(0xFFE0F7FA),
        onSurfaceVariant = Color.Black
    )

    // Applying background color and padding for the entire screen
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(cyanColorScheme.background) // Non-white background
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(cyanColorScheme.surface, MaterialTheme.shapes.large)
                .padding(16.dp)
        ) {
            // TopAppBar for the screen
            TopAppBar(
                title = { Text("Schedule Appointment") },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = cyanColorScheme.primary,
                    titleContentColor = cyanColorScheme.onPrimary
                ),
                modifier = Modifier.shadow(4.dp, shape = MaterialTheme.shapes.medium)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Date picker display with cyan highlight
            Text(
                text = "Selected Date: ${selectedDate.format(dateFormatter)}",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = cyanColorScheme.onPrimaryContainer
                ),
                modifier = Modifier
                    .padding(8.dp)
                    .background(
                        cyanColorScheme.secondaryContainer,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(12.dp)
            )

            // Material3 DatePicker visible on the screen
            val datePickerState = rememberDatePickerState()
            DatePicker(
                state = datePickerState,
                showModeToggle = true,  // Allows toggling between text input and calendar view
                modifier = Modifier.wrapContentSize()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Update selected date based on user's input from the calendar
            LaunchedEffect(datePickerState.selectedDateMillis) {
                datePickerState.selectedDateMillis?.let { millis ->
                    val calendar = Calendar.getInstance()
                    calendar.timeInMillis = millis
                    selectedDate = LocalDate.of(
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH) + 1, // Calendar.MONTH is 0-based
                        calendar.get(Calendar.DAY_OF_MONTH)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Available Time Slots section
            Text(
                text = "Available Time Slots",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = cyanColorScheme.onPrimaryContainer
                ),
                modifier = Modifier.padding(8.dp)
            )

            // Displaying time slots in a Row
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                TimeSlotButton(time = "9:00 AM")
                TimeSlotButton(time = "11:00 AM")
                TimeSlotButton(time = "3:00 PM")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Book Appointment Button
            Button(
                onClick = { /* Handle Appointment Booking */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = cyanColorScheme.primary,
                    contentColor = cyanColorScheme.onPrimary
                )
            ) {
                Text("Book Appointment")
            }
        }
    }
}

@Composable
fun TimeSlotButton(time: String) {
    // Ensure this function is called inside a Row or Column
    Button(
        onClick = { /* Handle Time Slot Selection */ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .shadow(2.dp, shape = RoundedCornerShape(10.dp)),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.secondary,
            contentColor = MaterialTheme.colorScheme.onSecondary
        ),
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(text = time)
    }
}


val PrimaryTeal = Color(0xFF00A7A6)
val LightTeal = Color(0xFFB2EBF2)
val ButtonTextColor = Color.White
val WavyShapeColor = Color(0xFF009688) // Color for the wavy design in the top-right corner

@Composable
fun WavyTopRightCornerDesign() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val path = Path().apply {
                // Start from the top-left corner
                moveTo(size.width, 0f)
                lineTo(size.width, size.height * 0.3f)

                // Create a wave effect
                quadraticBezierTo(
                    size.width * 0.6f, size.height * 0.4f, // Control point
                    size.width * 0.3f, size.height * 0.7f   // End point
                )

                lineTo(0f, size.height)
                lineTo(0f, 0f)
                close()
            }

            clipPath(path) {
                drawRect(
                    color = WavyShapeColor,
                    size = Size(size.width, size.height)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BedBookingScreen(navController: NavController) {
    // Create the box to layer the background shape and content.
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White) // Background of the screen is white
    ) {
        // Background top-right shape
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawPath(
                path = Path().apply {
                    moveTo(size.width * 0.6f, 0f)
                    cubicTo(
                        size.width * 0.85f, size.height * 0.15f,
                        size.width * 0.9f, size.height * 0.15f,
                        size.width, size.height * 0.2f
                    )
                    lineTo(size.width, 0f)
                    close()
                },
                color = Color(0xFF8CEEFF) // Lighter teal-blue color for the shape
            )
        }

        // Main content Column
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp)) // Top spacing to make room for the shape

            // "Bed Booking" title
            Text(
                text = "Bed Booking",
                style = MaterialTheme.typography.headlineMedium,
                color = Color(0xFF0074A6), // Darker blue shade for the title
                modifier = Modifier.padding(top = 16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Input fields for patient details
            OutlinedTextField(
                value = "",
                onValueChange = { /* Handle input */ },
                label = { Text("Patient Name") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF00A4CC), // Light teal-blue for the outline
                    unfocusedBorderColor = Color(0xFFC1E4F7)
                )
            )

            OutlinedTextField(
                value = "",
                onValueChange = { /* Handle input */ },
                label = { Text("Patient Age") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF00A4CC),
                    unfocusedBorderColor = Color(0xFFC1E4F7)
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Select Bed Type
            Text(
                text = "Select Bed Type:",
                style = MaterialTheme.typography.titleLarge,
                color = Color(0xFF0074A6), // Same blue shade for section titles
                modifier = Modifier.align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Bed Type Buttons
            Column(modifier = Modifier.fillMaxWidth()) {
                BedTypeButton("Emergency Bed")
                BedTypeButton("Private Room")
                BedTypeButton("Intensive Care Unit (ICU)")
                BedTypeButton("Maternity Ward")
                BedTypeButton("Surgical Recovery")
                BedTypeButton("General Bed")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Select Doctor Dropdown
            OutlinedTextField(
                value = "",
                onValueChange = { /* Handle input */ },
                label = { Text("Select Doctor") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                trailingIcon = { Icon(Icons.Default.ArrowDropDown, contentDescription = null) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF00A4CC),
                    unfocusedBorderColor = Color(0xFFC1E4F7)
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Clear and Book Bed Buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OutlinedButton(onClick = { /* Handle clear */ }) {
                    Text("Clear All")
                }

                Button(
                    onClick = { /* Handle bed booking */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF00A4CC), // Teal blue color for buttons
                        contentColor = Color.White
                    )
                ) {
                    Text("Book Bed")
                }
            }
        }
    }
}

@Composable
fun BedTypeButton(bedType: String) {
    Button(
        onClick = { /* Handle selection */ },
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00A4CC)), // Teal-blue color
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Text(bedType, color = Color.White)
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun PreviewMediMapApp() {
    MediMapApp()
}

@Preview(showBackground = true)
@Composable
fun PreviewRegistrationScreen() {
    val navController = rememberNavController()
    SignUpScreen(navController)
}

@Preview(showBackground = true)
@Composable
fun PreviewDoctorDirectoryScreen() {
    val navController = rememberNavController()
    DoctorDirectoryScreen(navController)
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun PreviewAppointmentScheduleScreen() {
    val navController = rememberNavController()
    AppointmentScheduleScreen(navController)
}

@Preview(showBackground = true)
@Composable
fun PreviewBedBookingScreen() {
    val navController = rememberNavController()
    BedBookingScreen(navController)
}



