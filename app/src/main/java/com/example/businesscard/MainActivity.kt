package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CreateBusinessCardView()
                }
            }
        }
    }
}

@Composable
fun CreatePresentationView(fullName: String, title: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.android_logo)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = "Android logo with an image of a green robot and the name Android below the image",
            modifier = Modifier
                .height(220.dp)
                .width(220.dp)
                .background(Color.Black)
        )
        Text(
            text = fullName,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            color = Color(0xff097969)
        )
    }
}

@Composable
fun CreateContactDataView(phoneNumber: String, socialMedia: String, email: String, modifier: Modifier = Modifier) {
    val myIcons = Icons.Rounded
    val phoneIcon = myIcons.Call
    val socialMediaIcon = myIcons.Share
    val emailIcon = myIcons.Email
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Row (
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Icon(
                phoneIcon,
                tint = Color(0xff097969),
                modifier = Modifier.padding(end = 8.dp),
                contentDescription = "icone de telefone verde"
            )
            Text(
                text = phoneNumber
            )
        }
        Row(
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Icon(
                socialMediaIcon,
                tint = Color(0xff097969),
                modifier = Modifier.padding(end = 8.dp),
                contentDescription = "icone de compartilhamento verde"
            )
            Text(
                text = socialMedia
            )
        }
        Row(
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Icon(
                emailIcon,
                tint = Color(0xff097969),
                modifier = Modifier.padding(end = 8.dp),
                contentDescription = "icone de email verde",
            )
            Text(
                text = email
            )
        }
    }
}

@Composable
fun CreateBusinessCardView(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier.padding(bottom = 64.dp)
        ) {
            CreatePresentationView(
                fullName = "Wendel Silva",
                title = "Android Developer"
            )
        }

        Row {
            CreateContactDataView(
                phoneNumber = "+55 (85) 994374611",
                socialMedia = "linkedin.com/in/-wendelsilva",
                email = "wendel245.ws@gmail.com"
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        CreateBusinessCardView()
    }
}