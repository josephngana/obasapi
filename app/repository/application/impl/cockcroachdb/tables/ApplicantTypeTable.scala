package repository.application.impl.cockcroachdb.tables

import domain.application.ApplicantType
import slick.jdbc.PostgresProfile.api._
import slick.lifted.ProvenShape
import util.connections.PgDBConnection
import util.connections.PgDBConnection.driver

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class ApplicantTypeTable(tag: Tag) extends Table[ApplicantType](tag, _tableName = "ApplicantType"){

  def applicantTypeId: Rep[String] = column[String]("MAIL_ID", O.PrimaryKey)

  def name: Rep[String] = column[String]("MAIL_KEY")


  
  override def * : ProvenShape[ApplicantType] = (applicantTypeId, name) <> ((ApplicantType.apply _).tupled, ApplicantType.unapply)
}

object ApplicantTypeTable extends TableQuery(new ApplicantTypeTable(_)) {
  def db: driver.api.Database = PgDBConnection.db

  def getEntity(applicantTypeId: String): Future[Option[ApplicantType]] = {
    db.run(this.filter(_.applicantTypeId === applicantTypeId).result).map(_.headOption)
  }

  def saveEntity(applicantType : ApplicantType): Future[ApplicantType] = {
    db.run(this returning this.map(_.applicantTypeId) into ((acc, applicantTypeId) => acc.copy(applicantTypeId = applicantTypeId)) +=applicantType)
  }

  def getEntities: Future[Seq[ApplicantType]] = {
    db.run(ApplicantTypeTable.result)
  }

  def deleteEntity(applicantTypeId: String): Future[Int] = {
    db.run(this.filter(_.applicantTypeId === applicantTypeId).delete)
  }

  def createTable = {
    db.run(
      ApplicantTypeTable.schema.createIfNotExists
    ).isCompleted
  }

}