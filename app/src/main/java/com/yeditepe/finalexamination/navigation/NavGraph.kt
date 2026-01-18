package com.yeditepe.finalexamination.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.yeditepe.finalexamination.ui.theme.RecipeDetailScreen
import com.yeditepe.finalexamination.ui.theme.RecipeListScreen
import com.yeditepe.finalexamination.viewmodel.RecipeViewModel

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "list") {
        composable("list") {
            // TODO: Call RecipeListScreen and pass navController
            val viewModel: RecipeViewModel = viewModel()
            RecipeListScreen(navController = navController, viewModel = viewModel
            )
        }
        composable(
            "detail/{recipeId}",
            arguments = listOf(navArgument("recipeId") { type = NavType.IntType })
        ) {
            // TODO: Retrieve recipeId and display RecipeDetailScreen
            backStackEntry ->
            val recipeId = backStackEntry.arguments?.getInt("recipeId") ?: -1
            if (recipeId >= 0) {
                val viewModel: RecipeViewModel = viewModel()
                RecipeDetailScreen(recipeId = recipeId, viewModel = viewModel)
            }
            else {
                // bos
            }
        }
    }
}