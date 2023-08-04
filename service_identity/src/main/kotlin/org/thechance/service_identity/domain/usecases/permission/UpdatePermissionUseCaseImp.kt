package org.thechance.service_identity.domain.usecases.permission

import org.koin.core.annotation.Single
import org.thechance.service_identity.domain.entity.Permission
import org.thechance.service_identity.domain.gateway.DataBaseGateway

@Single
class UpdatePermissionUseCaseImp(private val permissionGateway: DataBaseGateway) :
    UpdatePermissionUseCase {
    override suspend fun invoke(permissionId: String, permission: Permission): Boolean {
        return permissionGateway.updatePermission(permissionId, permission)
    }
}