package com.kaiju.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kaiju.app.navigation.Rutas
import com.kaiju.app.ui.screen.PantallaListaInventario
import com.kaiju.app.ui.screen.PantallaLogin
import com.kaiju.app.ui.theme.KaijuTheme
import com.kaiju.app.viewmodel.LoginViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KaijuTheme {
                val navController = rememberNavController()
                val loginViewModel: LoginViewModel = viewModel()

                NavHost(
                    navController = navController,
                    startDestination = Rutas.Login.ruta
                ) {
                    composable(Rutas.Login.ruta) {
                        PantallaLogin(
                            loginViewModel = loginViewModel,
                            onLoginExitoso = {
                                navController.navigate(Rutas.Inventario.ruta) {
                                    popUpTo(Rutas.Login.ruta) { inclusive = true }
                                }
                            }
                        )
                    }
                    composable(Rutas.Inventario.ruta) {
                        PantallaListaInventario(
                            onCerrarSesion = {
                                navController.navigate(Rutas.Login.ruta) {
                                    popUpTo(Rutas.Inventario.ruta) { inclusive = true }
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}