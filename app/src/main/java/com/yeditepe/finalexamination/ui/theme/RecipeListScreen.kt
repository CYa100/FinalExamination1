package com.yeditepe.finalexamination.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.yeditepe.finalexamination.model.Recipe
import com.yeditepe.finalexamination.viewmodel.RecipeViewModel

@Composable
fun RecipeListScreen(navController: NavController, viewModel: RecipeViewModel) {
    val recipes by viewModel.recipes.observeAsState(emptyList())

    LazyColumn {
        items(recipes) { recipe ->
            // TODO: Display recipe title and image
            // TODO: Use navController.navigate("detail/${recipe.id}") for navigation
            Row(modifier = Modifier.fillMaxWidth().clickable {
                navController.navigate("detail/${recipe.id}")
            }) {
                Text(text = recipe.title, modifier = Modifier.weight(1f), style = MaterialTheme.typography.bodyLarge)
                Image(painter = painterResource(id = recipe.imageResId), contentDescription = recipe.title)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRecipeListScreen() {
    // TODO: Provide a mock ViewModel and mock NavController
    FinalExaminationTheme {
        RecipeListScreen(navController = rememberNavController(), viewModel = RecipeViewModel())
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRecipeDetailScreen() {
    // TODO: Provide a mock recipe and call RecipeDetailScreen
    // Provide a mock ViewModel that returns a mock recipe
    val sample = Recipe(
        id = 1,
        title = "Sample Recipe",
        description = "This is a sample recipe description used only for preview purposes.",
        imageResId = 0
    )

    FinalExaminationTheme {
        RecipeDetailScreen(recipeId = 2, viewModel = RecipeViewModel())
    }
}
