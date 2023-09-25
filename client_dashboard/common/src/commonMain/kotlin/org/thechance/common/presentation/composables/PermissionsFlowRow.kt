package org.thechance.common.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
//import androidx.compose.ui.res.painterResource
import com.beepbeep.designSystem.ui.composable.BpChip
import com.beepbeep.designSystem.ui.theme.Theme
import org.thechance.common.presentation.users.UserScreenUiState
import org.thechance.common.presentation.util.kms

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PermissionsFlowRow(
    allPermissions: List<UserScreenUiState.PermissionUiState>,
    selectedPermissions: List<UserScreenUiState.PermissionUiState>,
    onUserPermissionClicked: (UserScreenUiState.PermissionUiState) -> Unit,
) {
    FlowRow(
        modifier = Modifier
            .fillMaxWidth()
            .background(Theme.colors.background)
            .padding(8.kms)
    ) {
        allPermissions.forEach { permission ->
//            BpChip(
//                label = permission.name.lowercase().capitalizeWords(),
//                modifier = Modifier.padding(8.kms),
//                onClick = { onUserPermissionClicked(permission) },
//                painter = painterResource(permission.iconPath),
//                isSelected = selectedPermissions.contains(permission)
//            )
        }
    }
}


private fun String.capitalizeWords(): String = split(" ")
    .joinToString(" ") { it.replaceFirstChar { char -> char.uppercase() } }
    .replace("_", " ")