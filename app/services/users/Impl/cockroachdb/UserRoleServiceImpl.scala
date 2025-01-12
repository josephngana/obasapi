package services.users.Impl.cockroachdb

import domain.users.UserRole
import repository.users.UserRoleRepository
import services.users.UserRoleService

import scala.concurrent.Future

class UserRoleServiceImpl extends UserRoleService {

  override def saveEntity(entity: UserRole): Future[Boolean] =
    UserRoleRepository.roach.saveEntity(entity)

  override def getEntities: Future[Seq[UserRole]] =
    UserRoleRepository.roach.getEntities

  override def getEntity(userRoleId: String): Future[Option[UserRole]] =
    UserRoleRepository.roach.getEntity(userRoleId)

  override def deleteEntity(entity: UserRole): Future[Boolean] =
    UserRoleRepository.roach.deleteEntity(entity)

  override def createTable: Future[Boolean] =
    UserRoleRepository.roach.createTable

}
