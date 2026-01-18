package com.yeditepe.finalexamination.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.yeditepe.finalexamination.viewmodel.RecipeViewModel

@Composable
fun RecipeDetailScreen(recipeId: Int, viewModel: RecipeViewModel) {
    val selectedRecipe = viewModel.getRecipeById(recipeId)

    selectedRecipe?.let { recipe ->
        // TODO: Display recipe title, image, and description
        Surface {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {
                Text(
                    text = recipe.title,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                // Image (if resource id is valid; painterResource will throw if invalid at runtime,
                // but using 0 as a placeholder in sample data is common in previews)
                if (recipe.imageResId != 0) {
                    Image(
                        painter = painterResource(id = recipe.imageResId),
                        contentDescription = "${recipe.title} image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 12.dp)
                    )
                }

                Text(
                    text = recipe.description,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    } ?: run {
        Text("Recipe not found")
    }
}