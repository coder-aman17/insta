package com.example.insta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstagramHomeUI()
        }
    }
}

@Composable
fun InstagramHomeUI() {
    Scaffold(
        topBar = { InstagramTopAppBar() },
        bottomBar = { InstagramBottomNavBar() }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            StoriesSection()
            Divider(color = Color.Gray, thickness = 0.5.dp)
            PostsSection()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InstagramTopAppBar() {
    TopAppBar(
        title = {
            Text(text = "Instagram", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        },
        actions = {
            IconButton(onClick = { /* Navigate to Messages */ }) {
                Icon(painter = painterResource(id = R.drawable.messenger), contentDescription = "Messenger")
            }
        }
    )
}

@Composable
fun StoriesSection() {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(10) {
            StoryItem()
        }
    }
}

@Composable
fun StoryItem() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(70.dp)
                .background(Color.LightGray, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            // Placeholder for profile picture
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile",
                modifier = Modifier.size(60.dp)
            )
        }
        Text(text = "User", fontSize = 12.sp, modifier = Modifier.padding(top = 4.dp))
    }
}

@Composable
fun PostsSection() {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(5) {
            PostItem()
        }
    }
}

@Composable
fun PostItem() {
    Column(modifier = Modifier.fillMaxWidth()) {
        // Post Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile",
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.LightGray, shape = CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Username", fontWeight = FontWeight.Bold)
        }
        // Post Image Placeholder
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(Color.Gray)
        )
        // Post Actions
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row {
                IconButton(onClick = { /* Like */ }) {
                    Icon(painter = painterResource(id = R.drawable.heart), contentDescription = "Like")
                }
                IconButton(onClick = { /* Comment */ }) {
                    Icon(painter = painterResource(id = R.drawable.comment), contentDescription = "Comment")
                }
                IconButton(onClick = { /* Share */ }) {
                    Icon(painter = painterResource(id = R.drawable.send), contentDescription = "Share")
                }
            }
            IconButton(onClick = { /* Save */ }) {
                Icon(painter = painterResource(id = R.drawable.bookmark), contentDescription = "Save")
            }
        }
        // Post Caption
        Text(
            text = "Liked by user123 and others",
            fontSize = 14.sp,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        Text(
            text = "View all comments",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
        )
    }
}

@Composable
fun InstagramBottomNavBar(
    horizontal: Alignment.Horizontal = Alignment.CenterHorizontally
) {
    BottomAppBar {
        IconButton(onClick = { /* Home */ }) {
            Icon(painter = painterResource(id = R.drawable.home), contentDescription = "Home")
        }
        IconButton(onClick = { /* Search */ }) {
            Icon(painter = painterResource(id = R.drawable.search), contentDescription = "Search")
        }
        IconButton(onClick = { /* Reels */ }) {
            Icon(painter = painterResource(id = R.drawable.reel), contentDescription = "Reels")
        }
        IconButton(onClick = { /* Shop */ }) {
            Icon(painter = painterResource(id = R.drawable.shop), contentDescription = "Shop")
        }
        IconButton(onClick = { /* Profile */ }) {
            Icon(painter = painterResource(id = R.drawable.profile), contentDescription = "Profile")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InstagramHomePreview() {
    InstagramHomeUI()
}
