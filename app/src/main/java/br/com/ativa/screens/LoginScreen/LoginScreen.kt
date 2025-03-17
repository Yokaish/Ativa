package br.com.ativa.screens.LoginScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.ativa.R
import br.com.ativa.ui.components.CheckboxRow
import br.com.ativa.ui.components.FormInput
import br.com.ativa.ui.components.MainButton
import br.com.ativa.ui.theme.PoppinsRegular
import br.com.ativa.ui.theme.PoppinsSemibold

@Composable
fun LoginScreen(loginScreenViewModel: LoginScreenViewModel, navController: NavController) {

//    var username by remember {
//        mutableStateOf("")
//    }

    val username by loginScreenViewModel.username.observeAsState(initial = "")
    val email by loginScreenViewModel.email.observeAsState(initial = "")
    val password by loginScreenViewModel.password.observeAsState(initial = "")


    var passwordVisible by remember {
        mutableStateOf(false)
    }

    val errorUsername by loginScreenViewModel.errorUsername.observeAsState(initial = false)

    val errorEmail by loginScreenViewModel.errorEmail.observeAsState(initial = false)

    val errorPassword by loginScreenViewModel.errorPassword.observeAsState(initial = false)


    val annotatedTerms = buildAnnotatedString {
        append("Eu concordo com os ")

        // Estilizando "Terms & Privacy" juntos
        pushStringAnnotation(tag = "TERMS", annotation = "terms_privacy")
        withStyle(style = SpanStyle(color = Color(0xFF1E1E1E), textDecoration = TextDecoration.Underline)) {
            append("Termos e Privacidade")
        }
        pop()
    }

    val annotatedSignUp = buildAnnotatedString {
        append("Não possui uma conta?")

        // Estilizando "Terms & Privacy" juntos
        pushStringAnnotation(tag = "SIGNUP", annotation = "sign_up")
        withStyle(style = SpanStyle(color = Color(0xFFE01257), fontFamily = PoppinsSemibold)) {
            append(" Registre-se")
        }
        pop()
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
        .background(Color.White)
        .padding(vertical = 60.dp, horizontal = 30.dp)
    ) {
        Column() {
            Image(
                painter = painterResource(id = R.drawable.ativa_logo),
                contentDescription = "Ativa Logo",
                modifier = Modifier
                    .height(66.dp)
                    .width(104.dp)
                    .padding(0.dp)
            )
            Text(
                text = "Insira suas credenciais para acessar sua conta",
                fontFamily = PoppinsRegular,
                fontSize = 16.sp,
                color = Color(0xFF1E1E1E),
                modifier = Modifier.padding(vertical = 36.dp)
            ) // Padding abaixo do texto)

            Column() {
                FormInput(
                    modifier = Modifier,
                    label = "Username",
                    value = username,
                    onValueChange = {
                        loginScreenViewModel.onUsernameChanged(it)
                        loginScreenViewModel.onErrorUsernameChanged(it)
                                    },
                    keyboardType = KeyboardType.Text
                )

                if (errorUsername) {
                    Text(text = "O campo de username não pode ficar vazio", color = Color.Red, modifier = Modifier.padding(top = 2.dp), fontFamily = PoppinsRegular, fontSize = 12.sp)
                }


                Spacer(modifier = Modifier.height(22.dp))

                FormInput(
                    modifier = Modifier,
                    label = "E-mail",
                    value = email,
                    onValueChange = { loginScreenViewModel.onEmailChanged(it)
                                    loginScreenViewModel.onErrorEmailChanged(it)},
                    keyboardType = KeyboardType.Email
                )

                if (errorEmail) {
                    Text(text = "O campo de e-mail não pode ficar vazio", color = Color.Red, modifier = Modifier.padding(top = 2.dp), fontFamily = PoppinsRegular, fontSize = 12.sp)
                }

                Spacer(modifier = Modifier.height(22.dp))

                FormInput(
                    modifier = Modifier,
                    label = "Senha",
                    value = password,
                    onValueChange = { loginScreenViewModel.onPasswordChanged(it)
                                    loginScreenViewModel.onErrorPasswordChanged(it)},
                    alternateLink = "Esqueceu sua senha?",
                    keyboardType = KeyboardType.Text, // Manter sempre como Text
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    passwordIcon = if (passwordVisible) R.drawable.open_eye else R.drawable.eye_closed,
                    iconModifier = Modifier
                        .clickable { passwordVisible = !passwordVisible } // Torna o ícone clicável
                        .size(24.dp)
                )

                if (errorPassword) {
                    Text(text = "O campo de senha não pode ficar vazio", color = Color.Red, modifier = Modifier.padding(top = 2.dp), fontFamily = PoppinsRegular, fontSize = 12.sp)
                }

                Spacer(modifier = Modifier.height(22.dp))
            }

            CheckboxRow(checked = false, onTermsClick = {}, annotatedText = annotatedTerms)

            Spacer(modifier = Modifier.height(42.dp))

            MainButton(text = "Entrar", font = PoppinsSemibold, heightBtn = 48, onClick = {
                loginScreenViewModel.checkInputError(
                    email, username, password, { navController.navigate("home") }
                ) }, modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = annotatedSignUp,
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(430),
                    fontFamily = PoppinsRegular,
                    color = Color(0xFF1E1E1E),
                ),
                modifier = Modifier.padding(top = 22.dp),

            )
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(LoginScreenViewModel(), navController = rememberNavController())
}