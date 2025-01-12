package services.users.Impl.cockroachdb

import domain.users.UserPassword
import repository.users.UserPasswordRepository
import services.users.UserPasswordService

import scala.concurrent.Future

class UserPasswordServiceImpl extends UserPasswordService {

  override def saveEntity(entity: UserPassword): Future[Boolean] =
    UserPasswordRepository.roach.saveEntity(entity)

  override def getEntities: Future[Seq[UserPassword]] =
    UserPasswordRepository.roach.getEntities

  override def getEntity(userPasswordId: String): Future[Option[UserPassword]] =
    UserPasswordRepository.roach.getEntity(userPasswordId)

  override def deleteEntity(entity: UserPassword): Future[Boolean] =
    UserPasswordRepository.roach.deleteEntity(entity)

  override def createTable: Future[Boolean] =
    UserPasswordRepository.roach.createTable

}
